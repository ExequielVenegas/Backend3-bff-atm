package cl.duoc.bancoxyz.bff.atm.dto;

import java.math.BigDecimal;

public record AtmSaldoResponse(
        Integer cuentaId,
        BigDecimal saldoDisponible
) {
}
