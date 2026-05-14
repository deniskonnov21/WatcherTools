// package com.example.watcher;

// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.Objects;

// public class DiffUtil {

//     public static String buildDiff(List<Product> oldList, List<Product> newList) {

//         Map<String, String> oldMap = oldList.stream()
//                 .collect(Collectors.toMap(Product::getName, Product::getPrice));

//         Map<String, String> newMap = newList.stream()
//                 .collect(Collectors.toMap(Product::getName, Product::getPrice));

//         StringBuilder sb = new StringBuilder();

//         // ✅ новые товары
//         for (Product p : newList) {
//             if (!oldMap.containsKey(p.getName())) {
//                 sb.append("➕ Добавлен:\n")
//                         .append(p.getName())
//                         .append(" — ")
//                         .append(p.getPrice())
//                         .append("\n\n");
//             }
//         }

//         // ❌ удалённые
//         for (Product p : oldList) {
//             if (!newMap.containsKey(p.getName())) {
//                 sb.append("❌ Удалён:\n")
//                         .append(p.getName())
//                         .append("\n\n");
//             }
//         }

//         // 🔄 изменённые цены
//         for (Product p : newList) {
//             if (oldMap.containsKey(p.getName())) {
//                 String oldPrice = oldMap.get(p.getName());

//                 if (!Objects.equals(oldPrice, p.getPrice())) {
//                     sb.append("🔄 Изменение цены:\n")
//                             .append(p.getName())
//                             .append("\n")
//                             .append(oldPrice)
//                             .append(" → ")
//                             .append(p.getPrice())
//                             .append("\n\n");
//                 }
//             }
//         }

//         return sb.toString();
//     }
// }
