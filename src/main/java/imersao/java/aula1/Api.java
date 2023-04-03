package imersao.java.aula1;

public enum Api {

    /*
    * Your public key
8cbc4c35a1cea0216f92059d54c914a7
Your private key
562e882d4d0ec8900e0f9ea46ed9066857da850f
    *
    * */
    IMBD_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json",new ContentExtractorImdb() ),
    IMDB_TOP_TV_SHOWS("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ContentExtractorImdb() ),
    NASA_APOD("https://api.nasa.gov/planetary/apod?api_key=" + new ReadProperties().getProperties("api-key-nasa") + "&start_date=2023-03-01&end_date=2023-03-10", new ContentExtractorNasa() ),
    GUITARRAS("https://guitarbank.fly.dev/guitarras",new ContentExtractorGuitarras() );

    private String url;
    private ContentExtractor extractor;

    Api (String url, ContentExtractor extractor){
        this.url = url;
        this.extractor = extractor;
    }

    public ContentExtractor getContentExtractor() {
        return extractor;
    }
    public String getUrl() {
        return url;
    }
}
