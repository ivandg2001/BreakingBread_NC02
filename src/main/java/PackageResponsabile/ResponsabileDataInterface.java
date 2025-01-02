package PackageResponsabile;

import PackageArmadietto.Lotto;

import java.sql.SQLException;

public interface ResponsabileDataInterface {

    public void creaOrdine(Ordine ordine , Lotto lotto) throws SQLException;

}
