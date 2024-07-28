package com.dinesh.springAI;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.*;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.ai.openai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.openai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {
    @Autowired
    private OpenAiImageModel openAiImageModel;

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

    @Autowired
    private OpenAiAudioSpeechModel openAiAudioSpeechModel;


    //text-to-image
    @GetMapping("/image/{prompt}")
    public String generateImage(@PathVariable("prompt") String prompt)
    {
        ImageResponse response = openAiImageModel.call(
                new ImagePrompt(prompt, OpenAiImageOptions.builder()
                        .withHeight(1024)
                        .withQuality("hd")
                        .withN(1)
                        .withWidth(1024)
                        .build())
        );
        return response.getResult().getOutput().getUrl();
    }


    @GetMapping("/image-to-text")
    public String generateImageText()
    {
        String response = ChatClient.create(chatModel).prompt()
                .user(userSpec -> userSpec.text("Explain what did you see this in the image")
                        .media(MimeTypeUtils.IMAGE_PNG,
                                new FileSystemResource("C:/Users/dines/OneDrive/Pictures/Screenshots/Screenshot 2024-07-22 120434.png")))
                .call()
                .content();
        return  response;
    }

    @GetMapping("audio-to-text")
    public String generateAudioDescription() {
        OpenAiAudioTranscriptionOptions options = OpenAiAudioTranscriptionOptions.builder()
                .withLanguage("en")
                .withResponseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT)
                .withTemperature(0f)
                .build();
        AudioTranscriptionPrompt prompt = new AudioTranscriptionPrompt(new FileSystemResource("C:/Spring/springAI/src/main/resources/file_example_WAV_1MG.wav"), options);

        AudioTranscriptionResponse response = openAiAudioTranscriptionModel.call(prompt);


        return response.getResult().getOutput();
    }


    @GetMapping("text-to-audio/{prompt}")
    public ResponseEntity<Resource> generateAudio(@PathVariable("prompt") String prompt) {
        OpenAiAudioSpeechOptions options = OpenAiAudioSpeechOptions.builder()
                .withModel("tts-1")
                .withSpeed(1.0f)
                .withVoice(OpenAiAudioApi.SpeechRequest.Voice.NOVA)
                .build();
        SpeechPrompt speechPrompt = new SpeechPrompt(prompt, options);

        SpeechResponse speechResponse = openAiAudioSpeechModel.call(speechPrompt);


        byte[] responseBytes = speechResponse.getResult().getOutput();


        ByteArrayResource byteArrayResource = new ByteArrayResource(responseBytes);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(byteArrayResource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("whatever.mp3")
                                .build().toString())
                .body(byteArrayResource);
    }


}
