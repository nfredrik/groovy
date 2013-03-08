import hudson.model.*

def job = Hudson.instance.getJob('count_co_files')  
job.scm.locations.each{ println it } //print current location 
job.scm = new hudson.scm.SubversionSCM("https://subversion03/svn/uniregrepos/branches/rtest") 