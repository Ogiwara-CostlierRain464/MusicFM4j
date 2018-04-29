package itsu.java.musicfm4j;

public class Music {
	
	private String title;
	private String artist;
	private String url;
	private String shareURL;
	private String coverURL;
	private String lyricURL;
	private String originalCoverURL;
	private String uploader;
	
	private double copyRightType;
	private double length;
	
	public Music(String title, String artist, String url, String shareURL, String coverURL, String lyricURL, String originalCoverURL, String uploader, double copyRightType, double length) {
		this.title = title;
		this.artist = artist;
		this.url = url;
		this.shareURL = shareURL;
		this.coverURL = coverURL;
		this.lyricURL = lyricURL;
		this.originalCoverURL = originalCoverURL;
		this.uploader = uploader;
		this.copyRightType = copyRightType;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getURL() {
		return url;
	}
	
	public String getShareURL() {
		return shareURL;
	}
	
	public String getCoverURL() {
		return coverURL;
	}
	
	public String getOriginalCoverURL() {
		return originalCoverURL;
	}
	
	public String getLyricURL() {
		return lyricURL;
	}
	
	public String getUploader() {
		return uploader;
	}
	
	public double getCopylightType() {
		return copyRightType;
	}
	
	public double getLength() {
		return length;
	}

}

//fork test
