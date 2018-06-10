package com.kkvideo;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.ComponentScan;
        import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.kkvideo.mapper")
@ComponentScan(basePackages = {"com.kkvideo","org.n3r.idworker"})
public class KkvideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkvideoApplication.class, args);
    }
}
