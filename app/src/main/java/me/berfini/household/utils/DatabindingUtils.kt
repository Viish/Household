package me.berfini.household.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.berfini.household.R
import me.berfini.household.BR

@BindingAdapter("android:src")
fun ImageView.setSourceImageResource(resource: Int) {
    this.setImageResource(resource)
}

@BindingAdapter("android:background")
fun ImageView.setSourceImageBackground(resource: Int) {
    this.setBackgroundResource(resource)
}

@BindingAdapter("entries", "layout")
fun <T> setEntries(
    viewGroup: ViewGroup,
    entries: List<T>?,
    layoutId: Int,
) {
    viewGroup.removeAllViews()
    if (entries != null) {
        val inflater = viewGroup.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        for (entry in entries) {
            val binding = DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                layoutId,
                viewGroup,
                false
            )
            binding.setVariable(BR.data, entry)

            // This is a bit hacky...
            binding.lifecycleOwner = viewGroup.context as AppCompatActivity

            viewGroup.addView(binding.root)
        }
    }
}

@BindingAdapter("hearts")
fun ImageView.setHearts(full: Boolean) {
    this.setImageResource(if (full) R.drawable.heart_full else R.drawable.heart_empty)
}

@BindingAdapter("diamonds")
fun ImageView.setDiamonds(full: Boolean) {
    this.setImageResource(if (full) R.drawable.diamond_full else R.drawable.diamond_empty)
}

@BindingAdapter("clubs")
fun ImageView.setClubs(full: Boolean) {
    this.setImageResource(if (full) R.drawable.club_full else R.drawable.club_empty)
}

@BindingAdapter("spades")
fun ImageView.setSpades(full: Boolean) {
    this.setImageResource(if (full) R.drawable.spade_full else R.drawable.spade_empty)
}

@BindingAdapter("wealth")
fun ImageView.setWealth(full: Boolean) {
    this.setImageResource(if (full) R.drawable.coin2_full else R.drawable.coin2_empty)
}

@BindingAdapter("decorum")
fun ImageView.setDecorum(value: Int) {
    val image = when (value) {
        5 -> R.drawable.decorum_5
        4 -> R.drawable.decorum_4
        3 -> R.drawable.decorum_3
        2 -> R.drawable.decorum_2
        1 -> R.drawable.decorum_1
        else -> R.drawable.decorum
    }
    setImageResource(image)
}

@BindingAdapter("aces")
fun ImageView.setAces(aces: ArrayList<Boolean>) {
    val image = if (aces[0]) {
        if (aces[1]) {
            if (aces[2]) {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_hdcsj
                    } else {
                        R.drawable.aces_hdcs
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_hdcj
                    } else {
                        R.drawable.aces_hdc
                    }
                }
            } else {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_hdsj
                    } else {
                        R.drawable.aces_hds
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_hdj
                    } else {
                        R.drawable.aces_hd
                    }
                }
            }
        } else {
            if (aces[2]) {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_hcsj
                    } else {
                        R.drawable.aces_hcs
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_hcj
                    } else {
                        R.drawable.aces_hc
                    }
                }
            } else {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_hsj
                    } else {
                        R.drawable.aces_hs
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_hj
                    } else {
                        R.drawable.aces_h
                    }
                }
            }
        }
    } else {
        if (aces[1]) {
            if (aces[2]) {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_dcsj
                    } else {
                        R.drawable.aces_dcs
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_dcj
                    } else {
                        R.drawable.aces_dc
                    }
                }
            } else {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_dsj
                    } else {
                        R.drawable.aces_ds
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_dj
                    } else {
                        R.drawable.aces_d
                    }
                }
            }
        } else {
            if (aces[2]) {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_csj
                    } else {
                        R.drawable.aces_cs
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_cj
                    } else {
                        R.drawable.aces_c
                    }
                }
            } else {
                if (aces[3]) {
                    if (aces[4]) {
                        R.drawable.aces_sj
                    } else {
                        R.drawable.aces_s
                    }
                } else {
                    if (aces[4]) {
                        R.drawable.aces_j
                    } else {
                        R.drawable.aces
                    }
                }
            }
        }
    }
    this.setImageResource(image)
}