
package moviestore;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static net.ucanaccess.converters.Functions.date;

/**
 *
 * @author user
 */
public class Select {
    static Connection conn = (Connection) Connectivity.openConnection();
    
     public static String[] listMediaInJList(JList list, JFrame frame, String selection, String searching2, String sort){
         String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where genre = '" + selection + "' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
                 
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
     }
     
     
     public static String[] searchListMediaInJList(JList list, JFrame frame,String search, String selection,String genreValue, String searching2, String sort){
         String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where genre = '"+genreValue+"' and "+search+" like '" + "%"+selection+"%" + "' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
         
        return items;
     }
     
     
     public static String[] searchAllListMediaInJList(JList list, JFrame frame,String search, String selection, String searching2, String sort){
         String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where "+search+" like '" + "%"+selection+"%" + "' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
         
        return items;
     }
     
     
     public static String[] sortedListMediaInJList(JList list, JFrame frame,String search, String sort){
         String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias order by "+search+" " +sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
     }
     
     
     public static String[] listAllMediaInJList(JList list, JFrame frame, String searching2, String sort){
         String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
     }
     
     
     public static Spacecraft quarySingleRow(String selection) throws SQLException {
         Spacecraft s = new Spacecraft();
         
         PreparedStatement stmt = conn.prepareStatement("select * from medias where title = "+ "'" +selection+"'");
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()){
                int id = rs.getInt("ID");
                String title_field = rs.getString("title");
                String year = rs.getString("created_year");
                String original_title = rs.getString("original_title");
                long size = rs.getLong("medias_size");
                String fileType = rs.getString("type_of_file");
                String length = rs.getString("length");
                String time = rs.getString("modified_at");
                String language = rs.getString("language");
                String genre = rs.getString("genre");
                String subgenre = rs.getString("sub_genre");
                String season = rs.getString("season");
                String episodes = rs.getString("no_episodes");
                String actors = rs.getString("actors");
                String diroctors = rs.getString("directors");
                String producers = rs.getString("producers");
                String writers = rs.getString("writers");
                String editors = rs.getString("editors");
                String photographer = rs.getString("photographers");
                String musician = rs.getString("musicians");
                String publisher = rs.getString("publishers");
                String content_provider = rs.getString("content_providers");
                String arrangement = rs.getString("arrangement");
                String media_feature = rs.getString("media_feature");
                String image_fullPath = rs.getString("image_path");
                String media_fullPath = rs.getString("media_path");
                

                s = new Spacecraft();
                
                s.setId(id);
                s.setTitle_field(title_field);
                s.setActors(actors);
                s.setArrangement(arrangement);
                s.setContent_provider(content_provider);
                s.setDiroctors(diroctors);
                s.setEditors(editors);
                s.setEpisodes(episodes);
                s.setFileType(fileType);
                s.setGenre(genre);
                s.setSubgenre(subgenre);
                s.setImage_fullPath(image_fullPath);
                s.setLanguage(language);
                s.setLength(length);
                s.setMedia_feature(media_feature);
                s.setMedia_fullPath(media_fullPath);
                s.setMusician(musician);
                s.setOriginal_title(original_title);
                s.setPhotographer(photographer);
                s.setProducers(producers);
                s.setPublisher(publisher);
                s.setSeason(season);
                s.setSize(size);
                s.setTime(time);
                s.setWriters(writers);
                s.setYear(year);
         }
         return s;
     }
     
     
     public static Spacecraft quarySingleEpisode(String selection) throws SQLException {
         Spacecraft s = new Spacecraft();
         PreparedStatement stmt = conn.prepareStatement("select * from serial where title = "+ "'" +selection+"'");
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()){
                int id = rs.getInt("ID");
                String title_field = rs.getString("title");
                long size = Long.parseLong(rs.getString("sizeof"));
                String fileType = rs.getString("typeof");
                String year = rs.getString("yearof");
                String language = rs.getString("language");
                String season = rs.getString("season");
                String episodes = rs.getString("episode");
                String media_fullPath = rs.getString("path");
                String original_title = "";
                
               
                String length = "";
                String time = "";
                
                String genre = "";
                String subgenre = "";
                
                String actors = "";
                String diroctors = "";
                String producers = "";
                String writers = "";
                String editors = "";
                String photographer = "";
                String musician = "";
                String publisher = "";
                String content_provider = "";
                String arrangement = "";
                String media_feature = "";
                String image_fullPath = "";
                

                s = new Spacecraft();
                
                s.setId(id);
                s.setTitle_field(title_field);
                s.setActors(actors);
                s.setArrangement(arrangement);
                s.setContent_provider(content_provider);
                s.setDiroctors(diroctors);
                s.setEditors(editors);
                s.setEpisodes(episodes);
                s.setFileType(fileType);
                s.setGenre(genre);
                s.setSubgenre(subgenre);
                s.setImage_fullPath(image_fullPath);
                s.setLanguage(language);
                s.setLength(length);
                s.setMedia_feature(media_feature);
                s.setMedia_fullPath(media_fullPath);
                s.setMusician(musician);
                s.setOriginal_title(original_title);
                s.setPhotographer(photographer);
                s.setProducers(producers);
                s.setPublisher(publisher);
                s.setSeason(season);
                s.setSize(size);
                s.setTime(time);
                s.setWriters(writers);
                s.setYear(year);
         }
         return s;
     }
     
     public static void update(Spacecraft sp) throws SQLException{
             
             PreparedStatement stmt = conn.prepareStatement("update medias set title = '"+sp.getTitle_field()+"', created_year = '"+sp.getYear()+"', original_title = '"
             + sp.getOriginal_title()+ "', type_of_file = '"+sp.getFileType()+"', length = '"+sp.getLength()+"', modified_at = '"+sp.getTime()
             +"', language = '"+sp.getLanguage()+"', genre = '"+sp.getGenre()+"', season = '"+sp.getSeason()+"', no_episodes = '"+sp.getEpisodes()+"', actors = '"+sp.getActors()
             +"', directors = '"+sp.getDiroctors()+"', producers = '"+sp.getProducers()+"', writers = '"+sp.getWriters()+"', editors = '"+sp.getEditors()+"', photographers = '"
             +sp.getPhotographer()+"', musicians = '"+sp.getMusician()+"', publishers = '"+sp.getPublisher()+"', content_providers = '"+sp.getContent_provider()+"', arrangement = '"
             +sp.getArrangement()+"', media_feature = '"+sp.getMedia_feature()+"', image_path = '"+sp.getImage_fullPath()+"', media_path = '"+sp.getMedia_fullPath()+"', medias_size = '"+sp.getSize()+"', sub_genre = '"+sp.getSubgenre()+"' where ID = "+sp.getId());
             
             stmt.executeUpdate();
             
     }
     
     public static void delete(String delete) throws SQLException{
             
             PreparedStatement stmt = conn.prepareStatement("delete from medias where title = '"+delete+"'");
             stmt.executeUpdate();
             
     }
     
     
     public static String[] listMediaInEpisodes(JList list, JFrame frame, String selection){
         String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from serial where serial_id = '" + selection + "'");
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_16px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "m4a":
                         case "M4A":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_16px.png"))));
                             break;
                         case "jpg":
                         case "JPG":
                         case "PNG":
                         case "png":
                         case "svg":
                         case "SVG":
                             case "BMP": case "bmp":
                                 case "GIF": case "gif":
                                     case "TIF": case "tif":
                                         case "ICO": case "ico":
                                             case "DIB": case "dib":
                                                 case "JPEG": case "jpeg":
                                                     case "JPE": case "jpe":
                                                         case "JFIF": case "jfif":
                                                             case "EMF": case "emf":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/picture_16px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_16px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
                 
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
     }

    static void updateEpisodeKilobyte(int id, long kilobyte) throws SQLException {
             PreparedStatement stmt = conn.prepareStatement("update medias set medias_size = medias_size + "+kilobyte+ " where ID = "+ id);
             stmt.executeUpdate();
    }

    static void transferHistory(File parentFile, File dest) {
        try {
            PreparedStatement stmt2 = conn.prepareStatement("insert into History values(?,?,?,?,?,?)");
            stmt2.setLong(1, 1);
            stmt2.setString(2, parentFile.getName());
            stmt2.setString(3, dest.getParentFile().toString());
            stmt2.setString(4, String.valueOf(date()));
            stmt2.setInt(5, Integer.parseInt(String.valueOf(date().getDate())));
            stmt2.setInt(6, Integer.parseInt(String.valueOf(date().getMonth())));
            stmt2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void selectHistory(JTable jTable1) {
        try {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            PreparedStatement stmt = conn.prepareStatement("select * from History order by dateof desc");
            ResultSet rs = stmt.executeQuery();
            String[] strg = new String[4];
            int i = 1;
            while(rs.next()){
                   strg[0] = String.valueOf(i);
                   strg[1] = rs.getString("source");
                   strg[2] = rs.getString("dest");
                   strg[3] = rs.getString("dateof");
                   i++;
                   model.addRow(strg);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    static void selectHistoryList(JTable jTable1, String selection) {
        try {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            PreparedStatement stmt = conn.prepareStatement("select * from History where "+selection+" order by dateof desc");
            ResultSet rs = stmt.executeQuery();
            String[] strg = new String[4];
            int i = 1;
            while(rs.next()){
                   strg[0] = String.valueOf(i);
                   strg[1] = rs.getString("source");
                   strg[2] = rs.getString("dest");
                   strg[3] = rs.getString("dateof");
                   i++;
                   model.addRow(strg);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void deleteHistory(JTable jTable1) {
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from History");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
    }

    static String[] listRecentMediaInEpisodes(JList<String> list, JFrame frame) {
        String[] items = new String[100000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from recent");
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             int j = 0;
             String check = null;
             while(rs.next()){
                 if((check == null ? (rs.getString("file")) != null : !check.equals(rs.getString("file")))){
                     String title = rs.getString("file");
                 String path = rs.getString("path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_16px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "m4a":
                         case "M4A":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_16px.png"))));
                             break;
                         case "jpg":
                         case "JPG":
                         case "PNG":
                         case "png":
                         case "svg":
                         case "SVG":
                             case "BMP": case "bmp":
                                 case "GIF": case "gif":
                                     case "TIF": case "tif":
                                         case "ICO": case "ico":
                                             case "DIB": case "dib":
                                                 case "JPEG": case "jpeg":
                                                     case "JPE": case "jpe":
                                                         case "JFIF": case "jfif":
                                                             case "EMF": case "emf":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/picture_16px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_16px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
                     check = rs.getString("file");
                 }
                 
                 
                 j++;
             }
             if(j >= 50){
                 PreparedStatement stmtt = conn.prepareStatement("delete from recent where ID in (select id from recent order by ID asc limit 100)");
                 stmtt.executeUpdate();
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
    }

    static void episodesUpdate(Spacecraft spp) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("update serial set title = '"+spp.getTitle_field()+"', sizeof = '"+spp.getSize()+"', typeof = '"+spp.getFileType()+"', yearof = '"+spp.getYear()+"', language = '"+spp.getLanguage()+"', season = '"+spp.getSeason()+"', episode = '"+spp.getEpisodes()+"', path = '"+spp.getMedia_fullPath()+"' where ID = "+spp.getId());
        stmt.executeUpdate();
    }

    
    void deleteEpisode(String id) throws SQLException {
        
             
             PreparedStatement stmt = conn.prepareStatement("delete from serial where serial_id = '"+id+"'");
             stmt.executeUpdate();
             
    }
    void deleteEpisode2(String name) throws SQLException {
             
             PreparedStatement stmt = conn.prepareStatement("delete from serial where title = '"+name+"'");
             stmt.executeUpdate();
             
    }
    
    
    
    public static Spacecraft quarySingleRecentEpisode(String selection) throws SQLException {
         Spacecraft s = new Spacecraft();
         PreparedStatement stmt = conn.prepareStatement("select * from recent where file = "+ "'" +selection+"'");
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()){
                int id = rs.getInt("ID");
                String title_field = rs.getString("file");
                long size = 0;
                String fileType = "";
                String year = "";
                String language = "";
                String season = "";
                String episodes = "";
                String media_fullPath = rs.getString("path");
                String original_title = "";
                
               
                String length = "";
                String time = "";
                
                String genre = "";
                String subgenre = "";
                
                String actors = "";
                String diroctors = "";
                String producers = "";
                String writers = "";
                String editors = "";
                String photographer = "";
                String musician = "";
                String publisher = "";
                String content_provider = "";
                String arrangement = "";
                String media_feature = "";
                String image_fullPath = "";
                

                s = new Spacecraft();
                
                s.setId(id);
                s.setTitle_field(title_field);
                s.setActors(actors);
                s.setArrangement(arrangement);
                s.setContent_provider(content_provider);
                s.setDiroctors(diroctors);
                s.setEditors(editors);
                s.setEpisodes(episodes);
                s.setFileType(fileType);
                s.setGenre(genre);
                s.setSubgenre(subgenre);
                s.setImage_fullPath(image_fullPath);
                s.setLanguage(language);
                s.setLength(length);
                s.setMedia_feature(media_feature);
                s.setMedia_fullPath(media_fullPath);
                s.setMusician(musician);
                s.setOriginal_title(original_title);
                s.setPhotographer(photographer);
                s.setProducers(producers);
                s.setPublisher(publisher);
                s.setSeason(season);
                s.setSize(size);
                s.setTime(time);
                s.setWriters(writers);
                s.setYear(year);
         }
         return s;
     }

    String[] ListMediaInJListCategory(JList<String> list, JFrame frame, String selection, String searching2, String sort, String cata) {
        String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where no_episodes = '"+cata+"'and genre = '" + selection + "' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
                 
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
    }

    String[] AllListMediaInJListCategory(JList<String> list, JFrame frame, String searching2, String sort, String cata) {
        String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where no_episodes = '"+cata+"' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
        
         return items;
    }

    String[] searchListMediaInJListCatagory(JList<String> list, JFrame frame, String search, String selection, String genreValue, String searching2, String sort, String cata) {
        String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where no_episodes = '"+cata+"' and genre = '"+genreValue+"' and "+search+" like '" + "%"+selection+"%" + "' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
         
        return items;
    }

    String[] searchAllListMediaInJListCatagory(JList<String> list, JFrame frame, String search, String selection, String searching2, String sort, String cata) {
        String[] items = new String[1000000];
         DefaultListModel listModel = new DefaultListModel();
             listModel.clear();
             
         try {
             PreparedStatement stmt = conn.prepareStatement("select * from medias where no_episodes = '"+cata+"' and "+search+" like '" + "%"+selection+"%" + "' order by "+searching2+" "+sort);
             ResultSet rs = stmt.executeQuery();
             int i = 0;
             while(rs.next()){
                 String title = rs.getString("title");
                 String path = rs.getString("media_path");
                 File newfile = new File(path);
                 if(newfile.isDirectory()){
                     listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                 }else{
                     
                        String ext1 = "";
                        int d = newfile.getName().lastIndexOf('.');
                        if (d > 0){
                            ext1 = newfile.getName().substring(d+1);
                          }
                     switch (ext1) {
                         case "mp3":
                         case "MP3":
                         case "wav":
                         case "WAV":
                             case "AAC": case "aac":
                                     case "AC3": case "ac3":
                                         case "AIF": case "aif":
                                             case "AIFF": case "aiff":
                                                 case "AU": case "au":
                                                     case "FLAC": case "flac":
                                                         case "M4A": case "m4a":
                                                             case "MKA": case "mka":
                                                                 case "MP2": case "mp2":
                                                                     case "OGG": case "ogg":
                                                                         case "WMA": case "wma":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/music_18px.png"))));
                             break;
                         case "mp4":
                         case "MP4":
                         case "avi":
                         case "AVI":
                         case "mkv":
                         case "MKV":
                         case "mov":
                         case "MOV":
                             case "flv": case "FLV":
                                     case "vob": case "VOB":
                                             case "3gp": case "3GP":
                                                     case "ASF": case "asf":
                                                             case "f4v": case "F4V":
                                                                     case "M4V": case "m4v":
                                                                             case "mpg": case "MPG":
                                                                                     case "MPEG": case "mpeg":
                                                                                             case "dpg": case "DPG":
                                                                                                     case "DV": case "dv":
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/video_18px.png"))));
                             break;
                         default:
                             listModel.addElement(new ImageAndText(title, new ImageIcon(Home.class.getResource("/moviestore/Icons/folder_18px.png"))));
                             break;
                     }
                     
                     
                 }
                 items[i] = title;
                 i++;
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(frame, "Loading Error " + ex.getMessage());
         }
         
         list.setCellRenderer(new Renderer());
         list.setModel(listModel);
         
        return items;
    }

    

}
