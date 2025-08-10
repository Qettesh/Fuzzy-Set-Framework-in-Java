package dev.lpa;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class FuzzySetFramework {
    private Map<String, Double> memberships;

    public FuzzySetFramework() {
        this.memberships = new HashMap<>();
    }

    /**
     * Adds an element to the fuzzy set with a specified membership degree.
     *
     * @param element     the element to add
     * @param membership  the membership degree (between 0 and 1)
     */
    public void addElement(String element, double membership) {
        if (membership < 0 || membership > 1){
            throw new IllegalArgumentException(("Membership degree must be between 0 and 1..."));
        }
        memberships.put(element, membership);
    }
    /**
     * Removes an element from the fuzzy set.
     *
     * @param element  the element to remove
     */
    public void removeElement(String element) {
        memberships.remove(element);
    }
    /**
     * Updates the membership degree of an element in the fuzzy set.
     *
     * @param element     the element to update
     * @param newMemberships  the new membership degree (between 0 and 1)
     */
    public void updateMemberships(String element, double newMemberships){
        if (newMemberships < 0 || newMemberships > 1){
            throw new IllegalArgumentException(("Membership degree must be between 0 and 1..."));
        }
        if(memberships.containsKey(element)) {
            memberships.put(element, newMemberships);
        } else {
            throw new NoSuchElementException("Element not found in the fuzzy set...");
        }
    }
    /**
     * Returns the membership degree of an element in the fuzzy set.
     * @Param element
     * @return the membership degree (or 0 if the element is not in the set)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : memberships.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
