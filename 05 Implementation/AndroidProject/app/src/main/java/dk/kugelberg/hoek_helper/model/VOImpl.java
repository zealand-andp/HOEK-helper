package dk.kugelberg.hoek_helper.model;

import static java.lang.Double.NaN;
import androidx.lifecycle.MutableLiveData;

public class VOImpl implements VO {

    private VE ve;
    private X x;
    private X x1;
    private X x2;
    private KO ko;
    private VO vo1;
    private VO vo2;
    private DOMK domk;
    private DOMK domk2;
    private STO sto;
    private SE se;

/*
VO = VE * X
VO = STO - KO
VO = DB - Oms
*/private

    private MutableLiveData<Double> vaerdi = new MutableLiveData<>();
    private MutableLiveData<Boolean> erBeregnet = new MutableLiveData<>();

    @Override
    public void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se) {
        this.ve = ve;
        this.x = x;
        this.ko = ko;
        this.domk = domk;
        this.sto = sto;
        this.se = se;
        vaerdi.setValue(NaN);
        erBeregnet.setValue(false);
    }

    @Override
    public void init1(X x1, VO vo1) {
        this.x1 = x1;
        this.vo1 = vo1;
    }

    @Override
    public void init2(X x2, VO vo2, DOMK domk2) {
        this.x2 = x2;
        this.vo2 = vo2;
        this.domk2 = domk2;
    }

    @Override
    public void setVaerdi(double vaerdi) {
        if (vaerdi < 0) {
            throw new VaerdiException();
        } else {
            this.vaerdi.setValue(vaerdi);
            setBeregnet(false);
        }
    }

    @Override
    public double getVaerdi() {
        return vaerdi.getValue();
    }

    @Override
    public void setBeregnet(boolean val){
        this.erBeregnet.setValue(val);
    }

    @Override
    public boolean getBeregnet(){
        return erBeregnet.getValue();
    }


    @Override
    public void beregn() {

        // TODO: konstruer beregner der kan regne VO ud via x1, x2, vo1, vo2, domk og domk2

        if (ve.getVaerdi() != NaN && x.getVaerdi() != NaN) {
            setVaerdi(ve.getVaerdi() * x.getVaerdi());
            setBeregnet(true);

        } else if (sto.getVaerdi() != NaN && ko.getVaerdi() != NaN) {
            setVaerdi(sto.getVaerdi() - ko.getVaerdi());
            setBeregnet(true);

        } /* else if (db.getVaerdi() != NaN && oms.getVaerdi() != NaN) {
            this.vaerdi = db.getVaerdi() - oms.getVaerdi();
            setBeregnet(true);

        } */ else if (getBeregnet()) {

            setVaerdi(NaN);

        }

    }
}

/*
VO = VE * X
VO = STO - KO
VO = DB - Oms
*/