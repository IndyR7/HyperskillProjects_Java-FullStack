function toTitleCase(str) {
    return str[0].toUpperCase() + str.substring(1).toLowerCase();
}

let textArea = document.querySelector("textarea");

document.getElementById("upper-case")
    .addEventListener("click", () => textArea.value = textArea.value.toUpperCase());

document.getElementById("lower-case")
    .addEventListener("click", () => textArea.value = textArea.value.toLowerCase());

document.getElementById("proper-case")
    .addEventListener("click",
        () => textArea.value = textArea.value.split(" ")
            .map(toTitleCase)
            .join(" "));

document.getElementById("sentence-case")
    .addEventListener("click",
        () => textArea.value = textArea.value.toLowerCase()
            .replace(/(^\s*\w|[.!?]\s+\w)/g,
                firstLetter => firstLetter.toUpperCase()));