package com.github.youssfbr.screensound.services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    private static final String YOUR_API_KEY = System.getenv("API_CHAT_GPT");

    private ConsultaChatGPT() {
        throw new IllegalStateException("Utility class");
    }

    public static String obterInformacao(String texto) {

        OpenAiService service = new OpenAiService(YOUR_API_KEY);

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText().trim();
    }
}
