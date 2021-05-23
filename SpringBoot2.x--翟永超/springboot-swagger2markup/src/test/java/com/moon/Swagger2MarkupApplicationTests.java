package com.moon;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Swagger2MarkupApplicationTests {

	@Test
	public void contextLoads() {

		System.out.println("--------------- Hello SpringBoot Swagger2Markup ---------------");
	}


	/**
	 * 生成 AsciiDoc 文档
	 *
	 * @throws Exception
	 *
	 * @author moon 2020/03/22  21:37
	 */
	@Test
	public void generateAsciiDocs() throws Exception {

		URL remoteSwaggerFile = new URL("http://localhost:8080/v2/api-docs");
		Path outputDirectory = Paths.get("src/docs/asciidoc/generated");

		// 输出 Ascii 格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.ASCIIDOC).build();

		// 在 outputDirectory 目录下生成文件，生成多个文件。
		Swagger2MarkupConverter.from(remoteSwaggerFile).withConfig(config).build().toFolder(outputDirectory);

		// 在 src/docs/asciidoc/generated/all 目录下生成文件，生成的是单一文件。
		// Swagger2MarkupConverter.from(remoteSwaggerFile).withConfig(config).build().toFile(Paths.get("src/docs/asciidoc/generated/all"));

	}


	/**
	 * 生成 markdown 的代码片段
	 *
	 * @throws Exception
	 *
	 * @author: moon  2020/03/22  21:36
	 */
	@Test
	public void generateMarkdownDocs() throws Exception {

		URL remoteSwaggerFile = new URL("http://localhost:8080/v2/api-docs");
		Path outputDirectory = Paths.get("src/docs/markdown/generated");

		// 输出 MarkDown 格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.MARKDOWN).build();

		Swagger2MarkupConverter.from(remoteSwaggerFile).withConfig(config).build().toFolder(outputDirectory);

	}


	/**
	 * 生成 confluence 的代码片段
	 *
	 * @throws Exception
	 *
	 * @author moon  2020/03/22  21:48
	 */
	@Test
	public void generateConfluenceDocs() throws Exception {

		URL remoteSwaggerFile = new URL("http://localhost:8080/v2/api-docs");
		Path outputDirectory = Paths.get("src/docs/confluence/generated");

		// 生成 confluence 格式文件
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP).build();

		Swagger2MarkupConverter.from(remoteSwaggerFile).withConfig(config).build().toFolder(outputDirectory);

	}


}
