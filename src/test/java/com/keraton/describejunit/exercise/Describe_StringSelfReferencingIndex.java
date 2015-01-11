package com.keraton.describejunit.exercise;

import com.keraton.describejunit.it.It;
import com.keraton.describejunit.it.ItRunner;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;


@RunWith(ItRunner.class)
@FixMethodOrder(NAME_ASCENDING)
public class Describe_StringSelfReferencingIndex {

    public static final int[] EMPTY_ARRAY = new int[0];
    private StringSelfReferencingIndex stringSelfReferencingIndex = new StringSelfReferencingIndex();

    @It("should create indexer with method int[] index(String input)")
    public void use_case_0() {
        stringSelfReferencingIndex.index("");
    }

    @It("should return an empty array if the input is null")
    public void use_case_1(){
        assertThat(stringSelfReferencingIndex.index(null)).isEqualTo(EMPTY_ARRAY);
    }

    @It("should return an empty array if the input is empty")
    public void use_case_2(){
        assertThat(stringSelfReferencingIndex.index("")).isEqualTo(EMPTY_ARRAY);
    }

    @It("should have the same number of elements between the index array and input")
    public void use_case_3(){
        String input = "aaa";
        assertThat(stringSelfReferencingIndex.index(input)).hasSize(input.length());
    }

    @It("should have default to 0 for index array")
    public void use_case_4(){
        assertThat(stringSelfReferencingIndex.index("abc")).isEqualTo(new int[] {-1,0,0});
    }

    @It("should always be -1 for the first value and 0 for the second value of the index array")
    public void use_case_5(){
        assertThat(stringSelfReferencingIndex.index("a")).isEqualTo(new int[] {-1});
        assertThat(stringSelfReferencingIndex.index("ab")).isEqualTo(new int[] {-1, 0});
    }

    @It("should be +1 only when input[n-1] == input[output[n-1]]")
    public void use_case_6(){
        assertThat(stringSelfReferencingIndex.index("aab")).isEqualTo(new int[] {-1,0,1});
        assertThat(stringSelfReferencingIndex.index("abc")).isEqualTo(new int[] {-1,0,0});
        assertThat(stringSelfReferencingIndex.index("aba")).isEqualTo(new int[] {-1,0,0});
        assertThat(stringSelfReferencingIndex.index("abac")).isEqualTo(new int[] {-1,0,0,1});
        assertThat(stringSelfReferencingIndex.index("abcd")).isEqualTo(new int[] {-1,0,0,0});
        assertThat(stringSelfReferencingIndex.index("aaad")).isEqualTo(new int[] {-1,0,1,2});
        assertThat(stringSelfReferencingIndex.index("abcabda")).isEqualTo(new int[] {-1,0,0,0,1,2,0});
    }

}
