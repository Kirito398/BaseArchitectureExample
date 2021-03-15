package ru.sir.presentation.base.recycler_view

class RecyclerViewBaseDataModel(
    private val data: Any,
    private val type: Int
) {

    fun getData(): Any = data
    fun getType(): Int = type

//    override fun equals(o: Any?): Boolean {
//        if (this === o) return true
//        if (o == null || javaClass != o.javaClass) return false
//        val that = o as RecyclerViewBaseDataModel
//
//        return if (type != that.type) false else Objects.equals(data, that.data)
//    }
//
//    override fun hashCode(): Int {
//        var result = data?.hashCode() ?: 0
//        result = 31 * result + type
//        return result
//    }
}