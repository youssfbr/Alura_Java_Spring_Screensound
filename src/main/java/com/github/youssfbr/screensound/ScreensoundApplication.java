package com.github.youssfbr.screensound;

import com.github.youssfbr.screensound.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

	private final Principal principal;

    public ScreensoundApplication(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		principal.exibeMenu();

	}
}
