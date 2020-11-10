package com.zupbootcamp.proposta.feing;

import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(value = "cartao", url = "http://localhost:8888/api")
public interface CartaoCriar {
    @RequestMapping(method = RequestMethod.GET ,value = "/cartoes?idProposta={idProposta}")
    Optional<CartaoResponse> analiseProposta(@PathVariable("idProposta") String idProposta);
}
