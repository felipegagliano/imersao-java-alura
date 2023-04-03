package imersao.java.aula1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GeradorDeFigurinhas {

    String diretorioSaida = "figurinhas/";

    public void cria(InputStream inputStream, String nomeArquivo, String texto, Double score) throws Exception {

        //ler a imagem original
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // tamanho da original e a nova altura
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = (int) (altura + (altura * 0.2)); // acrescenta 20% da altura original

        //criar imagem nova vazia
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a original sobre a nova
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);

        // le o sticker
        var classificacao = new Classificacao(score);
        String marker = classificacao.getNomeMarker();
        InputStream imgClassificacaoIS = new FileInputStream( new File(diretorioSaida + "/markers/",marker) );
        BufferedImage imgClassificacao = ImageIO.read(imgClassificacaoIS);

        // calcula o fator para manter o sticker com a proporção original
        float fator = imgClassificacao.getHeight() / (float)imgClassificacao.getWidth();

        // criar uma nova imagem com 20% da largura da imagem principal para acertar o tamanho do sticker
        int markerLargura = (int)(largura * 0.4);
        int markerAltura = (int)(markerLargura * fator);
        BufferedImage imgClassificacaoResized = new BufferedImage(markerLargura, markerAltura, BufferedImage.TRANSLUCENT);

        // copia o sticker na imagem ajustada
        Graphics2D graphicsResized = (Graphics2D)imgClassificacaoResized.createGraphics();
        graphicsResized.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphicsResized.drawImage(imgClassificacao,0,0, markerLargura,markerAltura, null);
        graphicsResized.dispose();

        // copia o sticker ajustado na principal
        int posMarkresX = largura - imgClassificacaoResized.getWidth();
        int posMarkresY = altura - imgClassificacaoResized.getHeight();
        graphics.drawImage(imgClassificacaoResized,posMarkresX,posMarkresY,null);



 //*************** texto sobre a imagem *****************
        // criar a nova fonte para o texto e setar as propriedades
        int tamanhoFonte = (novaAltura-altura) / 2 ;
        String[] fontes = {"Comic Sans MS", "Verdana", "Times New Roman", "Impact"};
        Font fonte = new Font(fontes[3],Font.TRUETYPE_FONT,tamanhoFonte);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);

        // setar a posicao do texto
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D bounds = fontMetrics.getStringBounds(texto, graphics);
        int posX = (int)((largura - bounds.getWidth()) / 2);
        int posY = (int)(novaAltura - (novaAltura-altura) + bounds.getHeight() );

        // escrever o texto na nova imagem
        graphics.drawString(texto,posX, posY);

        // cria o contorno do texto
        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        TextLayout textLayout = new TextLayout(texto,fonte, fontRenderContext);
        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posX, posY);
        graphics.setTransform(transform);

        // cria o pincel
        var outlineStroke = new BasicStroke(largura * 0.005f);
        graphics.setStroke(outlineStroke);
        graphics.setColor(Color.BLACK);

        // escreve o contorno
        graphics.draw(outline);
  //*************** texto sobre a imagem *****************


        // testa se o diretorio de saída existe e se não existir cria
        File directory = new File(diretorioSaida);
        if (!directory.exists() ) directory.mkdir();

        // gravar o arquivo de saida
        nomeArquivo = nomeArquivo + ".png";
        ImageIO.write(novaImagem,"png", new File(diretorioSaida, nomeArquivo) );
    }
}
