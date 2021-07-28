dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("io.zipkin.brave:brave-instrumentation-mysql8:5.13.3")
    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")

    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
    runtimeOnly("mysql:mysql-connector-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}