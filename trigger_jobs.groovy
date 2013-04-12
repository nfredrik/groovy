//I want to setup Jenkins job, that will trigger a list of jobs, based on theirs name pattern. For example I need to run all jobs that starts by Memmory-
//You can do this with Groovy. Configure a build step of type "Execute system Groovy script" (requires the Groovy plugin):

import hudson.model.*

for (item in Hudson.instance.items.findAll()) {
  if (item.name ==~ /^Memory-.+/) {
    if (item.isBuildable()) {
      my_cause = new Cause.UserIdCause();
      item.scheduleBuild(my_cause);
    }
  }
}