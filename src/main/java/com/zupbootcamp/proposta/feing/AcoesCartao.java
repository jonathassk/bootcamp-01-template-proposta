package com.zupbootcamp.proposta.feing;

import com.zupbootcamp.proposta.feing.requests.BloqueioRequest;
import com.zupbootcamp.proposta.feing.responses.BloqueioResponse;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.feing.responses.CarteiraResponse;
import com.zupbootcamp.proposta.requests.AvisoViagemRequest;
import com.zupbootcamp.proposta.requests.CarteiraRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(value = "funcoesCartao", url = "http://localhost:8888/api/cartoes")
public interface AcoesCartao {
    @PostMapping(value = "/{id}/bloqueios")
    Object bloqueioCartao(@PathVariable("id") String idCartao, @RequestBody BloqueioRequest bloqueioRequest);

    @PostMapping(value = "/{id}/avisos")
    CartaoResponse avisoViagem(@PathVariable("id") String idCartao, @RequestBody AvisoViagemRequest avisoRequest);

    @GetMapping(value = "/{id}")
    CartaoResponse findCartao(@PathVariable("id") String idCartao);

    @PostMapping(value = "/{id}/carteiras")
    CarteiraResponse vincularCarteira(@PathVariable("id") String idCartao, @RequestBody CarteiraRequest carteiraRequest);
}
