package cl.duoc.bancoxyz.bff.atm.controller;

import cl.duoc.bancoxyz.bff.atm.dto.AtmSaldoResponse;
import cl.duoc.bancoxyz.bff.atm.service.AtmCuentaService;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/atm")
public class AtmCuentaController {

    private final AtmCuentaService service;

    public AtmCuentaController(AtmCuentaService service) {
        this.service = service;
    }

    @GetMapping("/cuentas/{cuentaId}/saldo")
    public AtmSaldoResponse obtenerSaldo(@PathVariable @Min(1) Integer cuentaId) {
        return service.obtenerSaldo(cuentaId);
    }
}
