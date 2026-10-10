package cl.duoc.bancoxyz.bff.atm.service;

import cl.duoc.bancoxyz.bff.atm.dto.AtmSaldoResponse;
import cl.duoc.bancoxyz.bff.common.client.AccountServiceClient;
import org.springframework.stereotype.Service;

@Service
public class AtmCuentaService {

    private final AccountServiceClient client;
    public AtmCuentaService(AccountServiceClient client) { this.client = client; }

    public AtmSaldoResponse obtenerSaldo(Integer cuentaId) {
        var cuenta = client.findAccount(cuentaId);
        return new AtmSaldoResponse(cuenta.accountId(), cuenta.availableBalance());
    }
}
