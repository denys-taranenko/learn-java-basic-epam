package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Family {

    private Set<Person> partners;
    private Set<Person> children;
    private Map<Currency, BigInteger> account;

    public Family() {
    }

    public Set<Person> partners() {
        return this.partners;
    }

    public Set<Person> children() {
        return this.children;
    }

    public Map<Currency, BigInteger> account() {
        return this.account;
    }

    public Family partners(Set<Person> partners) {
        this.partners = partners;
        return this;
    }

    public Family children(Set<Person> children) {
        this.children = children;
        return this;
    }

    public Family account(Map<Currency, BigInteger> account) {
        this.account = account;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Family other)) {
            return false;
        }
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$partners = this.partners;
        final Object other$partners = other.partners;
        if (!Objects.equals(this$partners, other$partners)) {
            return false;
        }
        final Object this$children = this.children;
        final Object other$children = other.children;
        if (!Objects.equals(this$children, other$children)) {
            return false;
        }
        final Object this$account = this.account;
        final Object other$account = other.account;
        return Objects.equals(this$account, other$account);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Family;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $partners = this.partners;
        result = result * PRIME + ($partners == null ? 43 : $partners.hashCode());
        final Object $children = this.children;
        result = result * PRIME + ($children == null ? 43 : $children.hashCode());
        final Object $account = this.account;
        result = result * PRIME + ($account == null ? 43 : $account.hashCode());
        return result;
    }

    public String toString() {
        return "Family(partners=" + this.partners + ", children=" + this.children + ", account=" + this.account + ")";
    }
}
