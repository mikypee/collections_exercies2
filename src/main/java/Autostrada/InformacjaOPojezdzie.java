package Autostrada;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class InformacjaOPojezdzie {
    private String nrRej;
    private TypPojazdu typPojazdu;
    private LocalDateTime dataWjazdu;

    public InformacjaOPojezdzie(String nrRej, TypPojazdu typPojazdu) {
        this.nrRej = nrRej;
        this.typPojazdu = typPojazdu;
    }
}
