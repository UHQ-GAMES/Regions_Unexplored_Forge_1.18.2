package net.regions_unexplored.data.worldgen.noise;

public class RuleWeight {
    private static final double[] doubleArray = {
            1.0D/*0*/,
            0.675D/*1*/,
            0.6D/*2*/,
            0.55D/*3*/,
            0.525D/*4*/,
            0.51D/*5*/,
            0.5D/*6*/,
            0.476D/*7*/,
            0.46D/*8*/,
            0.45D/*9*/,
            0.4D/*10*/,
            0.39D/*11*/,
            0.375D/*12*/,
            0.35D/*13*/,
            0.34D/*14*/,
            0.33D/*15*/,
            0.325D/*16*/,
            0.31D/*17*/,
            0.306D/*18*/,
            0.303D/*19*/,
            0.3D/*20*/,
            0.275D/*21*/,
            0.25D/*22*/,
            0.225D/*23*/,
            0.22D/*24*/,
            0.2D/*25*/,
            0.19D/*26*/,
            0.18D/*27*/,
            0.175D/*28*/,
            0.16D/*29*/,
            0.151D/*30*/,
            0.15D/*31*/,
            0.14D/*32*/,
            0.13D/*33*/,
            0.1275D/*34*/,
            0.125D/*35*/,
            0.12D/*36*/,
            0.1175D/*37*/,
            0.115D/*38*/,
            0.1125D/*39*/,
            0.1D/*40*/,
            0.05D/*41*/,
            0.025D/*42*/,
            0.0235D/*43*/,
            0.0225D/*44*/,
            0.02D/*45*/,
            0.0165D/*46*/,
            0.0125D/*47*/,
            0.0116D/*48*/,
            0.011D/*49*/,
            0.0D/*50*/,
            -0.011D/*51*/,
            -0.0116D/*52*/,
            -0.0125D/*53*/,
            -0.0165D/*54*/,
            -0.02D/*55*/,
            -0.0225D/*56*/,
            -0.0235D/*57*/,
            -0.025D/*58*/,
            -0.05D/*59*/,
            -0.1D/*60*/,
            -0.1125D/*61*/,
            -0.115D/*62*/,
            -0.1175D/*63*/,
            -0.12D/*64*/,
            -0.125D/*65*/,
            -0.1275D/*66*/,
            -0.13D/*67*/,
            -0.14D/*68*/,
            -0.15D/*69*/,
            -0.151D/*70*/,
            -0.16D/*71*/,
            -0.175D/*72*/,
            -0.18D/*73*/,
            -0.19D/*74*/,
            -0.2D/*75*/,
            -0.22D/*76*/,
            -0.225D/*77*/,
            -0.25D/*78*/,
            -0.275D/*79*/,
            -0.3D/*80*/,
            -0.303D/*81*/,
            -0.306D/*82*/,
            -0.31D/*83*/,
            -0.325D/*84*/,
            -0.33D/*85*/,
            -0.34D/*86*/,
            -0.35D/*87*/,
            -0.375D/*88*/,
            -0.39D/*89*/,
            -0.44D/*90*/,
            -0.45D/*91*/,
            -0.46D/*92*/,
            -0.476D/*93*/,
            -0.5D/*94*/,
            -0.51D/*95*/,
            -0.525D/*96*/,
            -0.55D/*97*/,
            -0.6D/*98*/,
            -0.675D/*99*/,
            -1.0D/*100*/};
    public static double getPercent(int chance) {
        //throw error if chance int isn't 0-100
        if(chance<0||chance>100){
            throw new IllegalArgumentException("Surface Rule percentage out of bounds!");
        }
        //return percentage
        else{
            return doubleArray[chance];
        }
    }
}
