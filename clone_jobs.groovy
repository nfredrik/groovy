import hudson.model.*
/*
   Copyright Bolagsverket AB 2013

   Groovy script to copy a view with included jobs to a new view

   Preq: 
   
   - The server need to have svn installed
   - The subversion URL is hardcoded, need to be changed in case of new URL or svn server
   - jenkins user need to have a login on the subversion server
*/
def validSvnUrl(command)
{   
    println "subversion URL:" + command            
    
    def proc = command.execute()
    proc.waitFor()                    
    return proc.exitValue()  
}


// Parameters to the script
def build = Thread.currentThread().executable
def currentView = build.getEnvVars()['GammalVy']
def newView = build.getEnvVars()['NyVy']
 
// Create groovy variables from the enviroment variables
def currentJobPrefix = currentView
assert (currentView != null) || (currentView != ''), 'Current View have to be defined'
def newJobPrefix = newView
assert (newView != null) && newView != '' , 'New View have to be defined'

// Verify the view/branch we got is valid
def svnURL  = "https://subversion03/svn/uniregrepos/branches/" + newView + "/src"  
def command = "svn info --non-interactive --trust-server-cert --username jenkins --password J3nkM3 " + svnURL
                
if (validSvnUrl(command) != 0)
{
     println "Your input is wrong, cannot connect to subversion"
     return 1    
}

// Get current view
def view = Hudson.instance.getView(currentView)
assert view != null, 'Current View not defined in Jenkins'
 
// Copy all projects of a view 
def new_jobs =[]

for(item in view.getItems())
{

    // Create the new project name
    def newName = item.getName().replace(currentJobPrefix, newJobPrefix)

    // Copy the job, disable and save it
    def job = Hudson.instance.copy(item, newName)
    job.disabled = true
    job.scm = new hudson.scm.SubversionSCM(svnURL)    this is working beside the local dir
    
    // remoteLoc, localLoc, useUpdate, browser, excludedRegions
    //job.scm = new hudson.scm.SubversionSCM(svnURL,    "src",    false,     job.scm.browser,    "")
    
    job.save()
  
    // Update the workspace to avoid having two projects point to the same location
    AbstractProject project = job
    new_jobs.add(project)
    def new_workspace = project.getCustomWorkspace().replace(currentJobPrefix, newJobPrefix)
    project.setCustomWorkspace(new_workspace)
    project.save() 
}

// Create new view
hudsonInstance = hudson.model.Hudson.instance
def nView = new hudson.model.ListView(newView)
hudsonInstance.addView(nView)

// Add  new jobs to the view
for (job in new_jobs)
{
    nView.jobNames.add(job.getName())
}