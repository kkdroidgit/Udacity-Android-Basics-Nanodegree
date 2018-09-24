package in.paperwrk.newsapp.model;

public class NewsData {
    String newsTitle;
    String newsDate;
    String newsLink;
    String newsWriter;
    String section;
    String thumbnail;

    public NewsData(String newsTitle, String newsDate, String newsLink, String newsWriter, String section, String url) {
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsLink = newsLink;
        this.newsWriter = newsWriter;
        this.section = section;
        this.thumbnail = url;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsWriter() {
        return newsWriter;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public String getSection() {
        return section;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}