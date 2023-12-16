node {
  stage("Clone the project") {
    git branch: 'master', url: 'https://github.com/Niranjan1321/ProductManagement'
  }

  stage("Compilation") {
    sh "./mvnw clean install -DskipTests"
  }

    stage("Deployment") {
      sh 'nohup ./mvnw spring-boot:run -Dserver.port=8001 &'
    }
  }