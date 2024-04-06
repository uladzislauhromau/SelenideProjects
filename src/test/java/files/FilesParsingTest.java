package files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilesParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @DisplayName("Чтение файлов из архива")
    @Test
    public void filesParsingTest () throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("files.zip");
                ZipInputStream zis = new ZipInputStream(resource)
                ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) !=null) {
                if (entry.getName().contains("pdfForm")) {
                    PDF content = new PDF(zis);
                    assertThat(content.text).contains("PDF Form Example");
                } else if (entry.getName().contains("csvList")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = reader.readAll();
                    assertThat(content.get(0)[1]).isEqualTo("Average");
                } else if (entry.getName().contains("excelTable")) {
                    XLS content = new XLS(zis);
                    assertThat(content.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue().contains("Jane"));
                }
            }
        }
    }
}
