package com.zupbootcamp.proposta.feing;

import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cartao", url = "http://localhost:9999/api")
public interface CartaoCriar {
    @RequestMapping(method = RequestMethod.POST ,value = "/cartoes/")
    CartaoResponse analiseProposta(@RequestBody AnaliseRequest form);
}
