## How to Deploy

- Configure CI/CD Jenkins to run the pipeline.
- On Jenkinsfile, add stages for clone, test, SonarQube, and deploy.
- Create a Git repository and link Jenkins to the repository.
- CI/CD will build the image based on the Dockerfile and push it to OpenShift or the cloud of your choice.  
