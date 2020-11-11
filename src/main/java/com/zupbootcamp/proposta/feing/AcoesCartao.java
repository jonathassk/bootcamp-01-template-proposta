package com.zupbootcamp.proposta.feing;

import com.zupbootcamp.proposta.feing.requests.BloqueioRequest;
import com.zupbootcamp.proposta.feing.responses.BloqueioResponse;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(value = "funcoesCartao", url = "http://localhost:8888/api/cartoes")
public interface AcoesCartao {
    @RequestMapping(method = RequestMethod.POST ,value = "/{id}/bloqueios")
    Object bloqueioCartao(@PathVariable("id") String idCartao, @RequestBody BloqueioRequest bloqueioRequest);
}
