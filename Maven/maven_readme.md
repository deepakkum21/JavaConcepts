# Maven
- Maven is a **build and dependency management tool** for Java based application development.

## Maven – Settings File
1. settings.xml file **contains configurations** that are not specific to a project, but are global in nature. 
2. It also contains information that is not meant to be distributed (e.g. passwords).

## Location of Maven Settings File(settings.xml)
Maven can have two settings files working at a time:
- The **Maven installation directory**: **$M2_HOME/conf/settings.xml [global settings]**
- The **user’s home directory**: **${user.home}/.m2/settings.xml [user settings]**
- Both files are optional. If **both files are present, the values in the user home settings file overrides the values from global settings file**.
-           <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                                    http://maven.apache.org/xsd/settings-1.0.0.xsd">
                <localRepository/>
                <interactiveMode/>
                <usePluginRegistry/>
                <offline/>
                <pluginGroups/>
                <servers/>
                <mirrors/>
                <proxies/>
                <profiles/>
                <activeProfiles/>
            </settings>

| **ELEMENT NAME** |	**DESCRIPTION**  |                
| ---------------- | ------------------- |                                 
| localRepository |	Maven stores copies of plug-ins and dependencies locally in the C:\Users\<your_user_name>\.m2\repository folder. This element can be used to change the path of the local repository. |          
| interactiveMode |	As the name suggests, when this value is set to true, the default value, Maven interacts with the user for input. |          
| usePluginRegistry |	It decide that if Maven should use the ${user.home}/.m2/plugin-registry.xml file to manage plugin versions. Its default value is false. |          
| offline |	When set to true, this configuration instructs Maven to operate in an offline mode. The default is false. |          
| pluginGroups |	It contains a list of pluginGroup elements, each contains a groupId. The list is searched when a plugin is used and the groupId is not provided in the command line. This list automatically contains org.apache.maven.plugins and org.codehaus.mojo. |          
| servers |	Maven can interact with a variety of servers, such as Apache Subversion (SVN) servers, build servers, and remote repository servers. This element allows you to specify security credentials, such as the username and password, which you need to connect to those servers. |          
| mirrors |	As the name suggests, mirrors allow you to specify alternate locations for your repositories. |          
| proxies |	proxies contains the HTTP proxy information needed to connect to the Internet. |          
| profiles |	profiles allow you to group certain configuration elements, such as repositories and pluginRepositories. |          
| activeProfile |	The activeProfile allows you to specify a default profile to be active for Maven to use. |          