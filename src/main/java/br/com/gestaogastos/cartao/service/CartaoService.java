package br.com.gestaogastos.cartao.service;

import br.com.gestaogastos.cartao.dto.CartaoDto;
import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.predicate.CartaoPredicate;
import br.com.gestaogastos.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public List<CartaoDto> getByFilter(CartaoDto cartaoDto) {
        CartaoPredicate predicate = new CartaoPredicate()
                                    .comNome(cartaoDto.getNome())
                                    .comId(cartaoDto.getId())
                                    .comBancoId(cartaoDto.getBancoId());

        return cartaoRepository.getAll(predicate.build());
    }

    public void save(Cartao cartao) {
        cartaoRepository.save(cartao);
    }

    public CartaoDto findById(Integer id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);

        if (!cartao.isPresent()) {
            throw new ValidationException("Cartão não encontrado.");
        }

        return new CartaoDto(cartao.get().getId(), cartao.get().getNome(), null);
    }


}
