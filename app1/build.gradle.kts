dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")

    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
