package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author robert
 */
@Slf4j
public class Test {
    public static final String PIC_TYPE = "jpg,jpeg,png,gif";
    static final int low = -128;

    public static void main(String[] args) {
//        String a = "aaa";
//        String b = "bbb";
//        String c = "aaa" + "bbb";
//        String d = a + b;
//        String e = new String("aaa") + new String("bbb");
//        StringBuilder builder = new StringBuilder();
//        builder.append("aa");
//        builder.toString();

//        Integer[] arr = new Integer[] {1,2,3};
//        List<Integer> integers = Arrays.asList(arr);
//        integers.add(4);
//        List<Integer> list = new ArrayList<>(integers);
//        list.add(4);
//        System.out.println(integers);
//        System.out.println(list);

//        String c = new String("a") + new String("b");
//        String d = "ab";
//        System.out.println(c == d);
//
//        Integer[] fileIdsArray = {1,9,7,5,8,4,6,2};
//        List<Integer> fileIds = new ArrayList<>(Arrays.asList(fileIdsArray));
//        String sourceFileIds = fileIds.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
//        System.out.println(sourceFileIds);

//        String b = "\n";
//        String c = "\101";
//        // iterator会改变原集合里的元素
//        List<Long> a = new LinkedList<>();
//        a.add(5L);
//        a.add(4L);
//        a.add(9L);
//        a.add(8L);
//        a.add(6L);
//        System.out.println(a + "");
//        Iterator<Long> iter = a.iterator();
////        a.removeIf(next -> next == 4L);
//        while (iter.hasNext()) {
//            Long next = iter.next();
//            if (next == 4L) {
//                iter.remove();
//            }
//        }
//        System.out.println(a + "");


        //        String[] split = PIC_TYPE.split(",");
//        List<String> picList = Arrays.asList(split);
//        System.out.println(picList + "------" + picList.contains("gif"));
//        System.out.println(DateTime.now().getMillis());
//
//        String[] provinceNames = {"西藏自治区", "江苏省", "广西壮族自治区", "宁夏回族自治区"};
//        String[] suffixArray = {"回族","壮族","维吾尔","市","省","自治区"};
//        for (String provinceName : provinceNames) {
//            for (String suffix : suffixArray) {
//                provinceName = provinceName.replace(suffix, "");
//            }
//            System.out.println(provinceName);
//        }

        int a = 16;
        log.info((a >>> 1) + "");
        Integer b = new Integer(16);
        log.info(b.equals(a) + "");
    }
}
