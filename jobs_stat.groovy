Using Groovy script step getting the current status

file = new File("jobs.current.status")
hi.getItems(hudson.model.Project).each {project ->
try{
println(project.displayName+":"+project.lastBuild.result)
file << (project.displayName+":"+project.lastBuild.result+"\n")
} catch (NullPointerException e) {}
}

diff the status with previous one by shell script step
if diff -q jobs.current.status jobs.previous.status > /dev/null; then

If you interesting I can email you the config.xml 
