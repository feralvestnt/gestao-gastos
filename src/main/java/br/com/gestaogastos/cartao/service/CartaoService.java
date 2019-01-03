package br.com.gestaogastos.cartao.service;

import br.com.gestaogastos.cartao.dto.CartaoDto;
import br.com.gestaogastos.cartao.dto.CartaoFilter;
import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.predicate.CartaoPredicate;
import br.com.gestaogastos.cartao.repository.CartaoRepository;
import br.com.gestaogastos.comum.validation.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public List<CartaoDto> getByFilter(CartaoFilter cartaoFilter) {
        CartaoPredicate predicate = new CartaoPredicate()
                                    .comNome(cartaoFilter.getNome())
                                    .comId(cartaoFilter.getId())
                                    .comBancoId(cartaoFilter.getBancoId());

        return cartaoRepository.getAll(predicate.build());
    }

    public void save(Cartao cartao) {
        validaCartao(cartao);
        cartaoRepository.save(cartao);
    }

    private void validaCartao(Cartao cartao) {
        if (cartao.getNome() == null || cartao.getNome().equals("")) {
            throw new ValidacaoException("Informe o nome.");
        }

        if (cartao.getBanco() == null || cartao.getBanco().getId() == null) {
            throw new ValidacaoException("Informe o banco.");
        }
    }

    public CartaoDto findById(Integer id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);

        if (!cartao.isPresent()) {
            throw new ValidacaoException("Cartão não encontrado");
        }

        return new CartaoDto(cartao.get().getId(), cartao.get().getNome(), cartao.get().getBanco().getId());
    }

    public void delete(Integer cartaoId) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(cartaoId);
        if (cartaoOptional.isPresent()) {
            cartaoRepository.delete(cartaoOptional.get());
        } else {
            throw new ValidacaoException("Cartão não encontrado.");
        }

    }
}
