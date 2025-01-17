package app;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UrlDownloader {

    public String baixaHtml(String urlString) throws IOException, InterruptedException {
        URI uri = URI.create(urlString);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void salvaEvidencia(String conteudoHtml, String localArquivo) throws IOException {
        String fileName = "evidencia_" + retornaHoraAtual() + ".html";
        Path filePath = Paths.get(localArquivo, fileName);
        Files.writeString(filePath, conteudoHtml);
        System.out.println("Evidência salva em: " + filePath.toString());
    }

    private String retornaHoraAtual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return LocalDate.now().format(formatter);
    }
}