package io.github.robaertschi;

public enum Jobs {
    Forster,
    Crafter,
    Miner,
    Farmer,
    Butcher;

    /**
     * Returns a Job based of the Int that got inputed.
     * @param i Only allows values from 0 to 4.
     * @return Returns the corresponding Job.
     */

    public static Jobs from(int i) {
        if (i == 0) {
            return Forster;
        } else if (i == 1) {
            return Crafter;
        } else if (i == 2) {
            return Miner;
        } else if (i == 3) {
            return Farmer;
        } else if (i == 4) {
            return Butcher;
        } else {
            throw new IllegalArgumentException("Only values from 0 to 4 are accepted.");
        }
    }
}
