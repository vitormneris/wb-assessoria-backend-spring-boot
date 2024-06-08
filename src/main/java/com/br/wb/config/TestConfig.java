package com.br.wb.config;

import com.br.wb.domain.Installment;
import com.br.wb.domain.Usuario;
import com.br.wb.enums.PaymentStatus;
import com.br.wb.respositories.InstallmentRepository;
import com.br.wb.respositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {

    private final MongoTemplate mongoTemplate;
    private final InstallmentRepository installmentRepository;
    private final UsuarioRepository usuarioRepository;


    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.getDb().drop();

        // UserId: 123
        Installment installment1 =
                new Installment(null, "123", 1, "Parcela 1: processo de naturalização", 229.0, LocalDateTime.parse("2024-03-01T00:00:00"), LocalDateTime.parse("2024-03-30T00:00:00" ), PaymentStatus.PAGO);
        Installment installment2 =
                new Installment(null, "123", 2, "Parcela 2: processo de naturalização", 229.0, LocalDateTime.parse("2024-04-01T00:00:00"), LocalDateTime.parse("2024-04-30T00:00:00" ), PaymentStatus.VENCIDO);
        Installment installment3 =
                new Installment(null, "123", 3, "Parcela 3: processo de naturalização", 229.0, LocalDateTime.parse("2024-05-01T00:00:00"), LocalDateTime.parse("2024-05-30T00:00:00" ), PaymentStatus.PENDENTE);

        // UserId: 321
        Installment installment4 =
                new Installment(null, "321", 1, "Parcela 1: processo de naturalização", 229.0, LocalDateTime.parse("2024-03-01T00:00:00"), LocalDateTime.parse("2024-03-30T00:00:00" ), PaymentStatus.PAGO);
        Installment installment5 =
                new Installment(null, "321", 2, "Parcela 2: processo de naturalização", 229.0, LocalDateTime.parse("2024-04-01T00:00:00"), LocalDateTime.parse("2024-04-30T00:00:00" ), PaymentStatus.VENCIDO);
        Installment installment6 =
                new Installment(null, "321", 3, "Parcela 3: processo de naturalização", 229.0, LocalDateTime.parse("2024-05-01T00:00:00"), LocalDateTime.parse("2024-05-30T00:00:00" ), PaymentStatus.PENDENTE);

        installmentRepository.saveAll(Arrays.asList(installment1, installment2, installment3, installment4, installment5, installment6));
        List<String> telefones = new ArrayList<>();
        String tel1 = "11955696863";
        String tel2 = "11955696864";
        String tel3 = "11955696865";
        telefones.add(tel1);
        telefones.add(tel2);
        telefones.add(tel3);

        Usuario.RNMDocument rnm = new Usuario.RNMDocument("12345640","classificação","11/10/2005");
        Usuario usuario = new Usuario(null, "Neris pinto","nerispinto@gmail.com","1234","111111111111",rnm,"paquistão",telefones );
        usuarioRepository.save(usuario);

    }
}
