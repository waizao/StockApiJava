package stock;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExportTool {
    public static <T> T toObj(String data, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(gson.fromJson(data, Result.class).getData()), type);
    }

    public static List<String> toTxt(String data) {
        return Arrays.stream(data.split(";")).collect(Collectors.toList());
    }

    public static List<Map<String, String>> toJson(String data) {
        return (List<Map<String, String>>) new Gson().fromJson(data, Result.class).getData();
    }

    public static void toFile(String data, File file) throws IOException {
        FileUtils.forceMkdir(file.getParentFile());
        FileUtils.write(file, data, Charset.forName("UTF-8"));
    }
}
