
//println Hudson.instance.User.current()

for (item in hudson.model.Hudson.instance.items) 
{ 
    println "Working on project <$item.name>" 
    builders =  item.getBuilders(); 

    for (i in builders.toArray()) 
    {
        println i.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
        println ""
        println "builder methods"
        for( method in i.getClass().getMethods() )
        {
           println "\t" + method.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
        }
        println ""
        println "builder descriptor methods"
        for( method in i.getDescriptor().getClass().getMethods() )
        {
           println "\t" + method.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
        }
    break
    }
  break
} 

println ""
println "Scm"
println hudson.model.Hudson.instance.getScm()
println ""

println ""
println "Instance items:"
for (item in hudson.model.Hudson.instance.items) 
{
  println( item.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" ) )
  println ""
  println "\tScm:"
  println "\t" + item.getScm()
  println ""
  println "Scm Methods"
  for( method in item.getScm().getClass().getMethods() )
  {
     println "\t" + method.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
   }

  println ""
  println "Class Methods"
  for( method in item.getClass().getMethods() )
  {
     println "\t" + method.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
   }
  
  for( field in item.getClass().getFields() )
  {
     println "\t" + field.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
   }

  println ""
  println "descriptor Methods"

  for( method in item.getDescriptor().getClass().getMethods() )
  {
     println "\t" + method.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "hudson.model.", "" )
   }
   break
} 

println ""
println hudson.model.Hudson.instance.pluginManager.getPlugin( "subversion" ).getUpdateInfo()
println ""
println "subversion plugion methods"
for( i in hudson.model.Hudson.instance.pluginManager.getPlugin( "subversion").getClass().getMethods() )
{
println i.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" )
}

println ""
println "subversion plugion fields"
for( i in hudson.model.Hudson.instance.pluginManager.getPlugin( "subversion").getClass().getFields() )
{
println i.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" )
}

println ""
println "subversion plugion.getPlugin() methods"
for( i in hudson.model.Hudson.instance.pluginManager.getPlugin( "subversion").getPlugin().getClass().getMethods() )
{
println i.toString().replace( "hudson.PluginWrapper.", "" ).replace( "java.lang.", "" ).replace( "java.util.",""). replace( " ","\t" ).replace( "java.lang", "" )
}

println ""
println "PluginManager Methods"
for( i in hudson.PluginManager.getMethods() )
{
    println i
}

println ""
println "Plugins"
for( i in hudson.model.Hudson.instance.pluginManager.plugins )
{
    println i
}

println ""
println " Methods"
for( i in hudson.model.Hudson.getMethods() )
{
    println i
}

println ""
println " Fields"
for( i in hudson.model.Hudson.getFields())
{
    println i
}

println hudson.model.Hudson.instance.isAdmin()