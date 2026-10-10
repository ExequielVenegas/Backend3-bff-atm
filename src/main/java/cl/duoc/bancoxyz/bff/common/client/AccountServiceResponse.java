package cl.duoc.bancoxyz.bff.common.client;
import java.math.BigDecimal;
public record AccountServiceResponse(Integer accountId, BigDecimal availableBalance) {}
