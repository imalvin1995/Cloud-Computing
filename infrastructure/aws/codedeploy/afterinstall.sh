#!/bin/bash


# update the permission and ownership of WAR file in the tomcat webapps directory
#sudo service tomcat8 stop
sudo su
cd /
cd opt/tomcat/latest/webapps
sudo chown tomcat:tomcat ROOT.war
sudo chmod 755 ROOT.war
sudo systemctl restart tomcat

