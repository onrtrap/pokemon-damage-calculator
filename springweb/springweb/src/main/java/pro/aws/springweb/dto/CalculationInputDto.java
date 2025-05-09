package pro.aws.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculationInputDto {
    private boolean isCritical;

    private boolean isStab;

    private int level;

    private int power;

    private int attack;

    private int defense;



    public boolean checkValid(){
        return this.level >= 1 && this.level <= 100 ? this.attack > 1 ? this.defense > 1 ? this.power > 1 ? true : false : false : false : false;
    }

    @Override
    public String toString(){
        return ("Power: " + this.getPower() + "\n"
        + "Attack: " + this.getAttack() + "\n"
        + "Defense: " + this.getDefense() + "\n"
        + "Level: " + this.getLevel() + "\n"
                + "Stab: " + this.getIsStab() + "\n"
                + "Critical: " + this.getIsCritical() + "\n");


    }

    public boolean getIsStab(){
        return isStab;
    }

    public boolean getIsCritical(){
        return isCritical;
    }
}
