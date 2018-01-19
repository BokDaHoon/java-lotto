package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
    }

    public static Lotto of(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException();
        }

        String[] values = text.split(",");
        Set<LottoNumber> lotto = new HashSet<>();
        for (String value : values) {
            lotto.add(LottoNumber.of(value));
        }
        return new Lotto(lotto);
    }

    public static Lotto of(Integer... numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
