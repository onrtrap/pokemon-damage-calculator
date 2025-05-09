package pro.aws.springweb.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import pro.aws.springweb.dto.CalculationInputDto;
import java.util.Random;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService{

    Random random = new Random();

    @Override
    public int damageCalc(CalculationInputDto input){

        double randomFactor = (double)(random.nextInt(16) + 85) / 100;

        double crit = input.getIsCritical() ? 2 : 1;

        double stab = input.getIsStab() ? 1.5 : 1;

        double seg1 = (2.0 * (double)input.getLevel()) / 5.0 + 2;

        double seg2 = (double) input.getPower() * ((double)input.getAttack() / (double)input.getDefense());

        return (int)(((seg1 * seg2)/50 + 2) * stab * randomFactor * crit);
    }
}
