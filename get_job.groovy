import hudson.model.*


// Get current view
def view = hudson.model.Hudson.instance.getView("admin")
assert view != null, 'Current View not defined in Jenkins'


for(item in view.getItems())
{

    print item.dump()
    
    //AbstractProject project = item
    
    //print project.dump()
    
}
