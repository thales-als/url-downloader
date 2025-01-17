package app;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a URL que deseja baixar: ");
        String url = scanner.nextLine();
        String localArquivo = "/opt/dev/projects/url-downloader/src/evidencias";

        UrlDownloader downloader = new UrlDownloader();

        try {
            String htmlContent = downloader.baixaHtml(url);
            downloader.salvaEvidencia(htmlContent, localArquivo);
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}