package dev.langchain4j.store.embedding.filter.comparison;

import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.store.embedding.filter.Filter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static dev.langchain4j.internal.ValidationUtils.ensureNotBlank;
import static dev.langchain4j.internal.ValidationUtils.ensureNotNull;
import static dev.langchain4j.store.embedding.filter.comparison.TypeChecker.ensureTypesAreCompatible;

@ToString
@EqualsAndHashCode
public class IsExists implements Filter {

    private final String key;
    

    public IsExists(String key) {
        this.key = ensureNotBlank(key, "key");
    }

    public String key() {
        return key;
    }


    @Override
    public boolean test(Object object) {
        if (!(object instanceof Metadata)) {
            return false;
        }

        Metadata metadata = (Metadata) object;
        if (!metadata.containsKey(key)) {
            return false;
        }

        return false;
    }
}
