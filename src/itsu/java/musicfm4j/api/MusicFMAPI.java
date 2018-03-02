package itsu.java.musicfm4j.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import itsu.java.musicfm4j.Music;
import itsu.java.musicfm4j.http.GetHeader;
import itsu.java.musicfm4j.http.Http;

public class MusicFMAPI {
	
	private static Gson gson = new Gson();
	
	@SuppressWarnings("unchecked")
	public static List<Music> searchMusic(String keyword, int pageNumber) throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
		String encoded = URLEncoder.encode(keyword, "UTF-8");
		String request = "http://www.musicfmjp.com/api/search?page_no=" + pageNumber + "&query=" + encoded + "&channel_lang=ja&appname=musicfmjp&appid=com.musicfmjp.web";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/search?keywords=" + encoded + "&channel_lang=ja&page_no=" + pageNumber);
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("items");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (int) map.get("copylight_type"), (int) map.get("length")));
        }
        
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getJapanOriconSingleChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=30005";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getEnglandSingleChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=30004";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getBillboardChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=30001";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getJPopChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=31002";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getChinaChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=31000";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getUSChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=31001";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getKPopChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=31003";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getOriconChosenChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=30017";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getBeatportChart() throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=31016";
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Music> getChartById(int id) throws MalformedURLException, IOException, URISyntaxException {
        List<Music> result = new ArrayList<>();
        
		String request = "http://www.musicfmjp.com/api/rank_song_list?channel_lang=ja&rank_id=" + id;
        
        GetHeader header = new GetHeader()
                .setHost("www.musicfmjp.com")
                .setConnection(true)
                .setAccept("application/json, text/javascript, */*; q=0.01")
                .setUserAgent("Mozilla/5.0(Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/59.0.3071.90 Safari/537.36 Vivaldi/1.91.867.38")
                .setAcceptLanguage("ja,en-US;q=0.8,en;q=0.6")
                .setReferer("http://www.musicfmjp.com/web/index?channel_lang=ja");
        
        String got = Http.get(request, header);
        
        Map<String, Object> temp1 = ((Map<String, Object>) gson.fromJson(got, Map.class));
        List<Map<String, Object>> temp2 = (List<Map<String, Object>>) ((Map<String, Object>) temp1.get("data")).get("songs");

        for(Map<String, Object> map : temp2) {
            result.add(new Music((String) map.get("title"), (String) map.get("artist"), (String) map.get("url"), (String) map.get("share_uri"), (String) map.get("coverURL"), (String) map.get("lyricURL"), (String) map.get("ori_coverURL"), (String) map.get("uploader"), (double) map.get("copyright_type"), (double) map.get("length")));
        }
        
        return result;
	}

}
